/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 */
package innovationcare.app.antibioticguidelines.ui;

import innovationcare.app.antibioticguidelines.R;
import java.io.File;
import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/*
 * Modification History
 * --------------------
 * 17-Jul-2013  Meng  Initial version.
 * 
 */
/**
 * The activity class for the antibiotic list page.
 *
 */
public class AntibioticListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antibiotic_list);
        setTitle("Antibiotic List");

        ListView lv = (ListView)findViewById(R.id.categoryList);
        final ArrayList<String> list = getList();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String drugName = list.get(arg2);
				String path = getPath(drugName);
				if(path.contains("http")) {
					if(isPDFSupported(AntibioticListActivity.this)) {
						downloadAndOpenPDF(AntibioticListActivity.this, path);
					}
					else {
			            askToOpenPDFThroughGoogleDrive( AntibioticListActivity.this, path );
			        }
				}
			}

        });
        lv.setAdapter(adapter);

    }

    public String getPath(String drugName) {
		return "http://bitcoin.org/bitcoin.pdf";
	}


    //get the arraylist from backend
    public ArrayList<String> getList() {
    	ArrayList<String> list = new ArrayList<String>();
    	list.add("Cat 1");
    	list.add("Cat 2");
    	list.add("Cat 3");
    	list.add("Cat 4");
    	list.add("Cat 5");
    	list.add("Cat 6");
    	return list;
    }

    @SuppressLint("NewApi") public void downloadAndOpenPDF(final Context context, final String pdfUrl) {
        // Get filename
        final String filename = pdfUrl.substring( pdfUrl.lastIndexOf( "/" ) + 1 );
        // The place where the downloaded PDF file will be put
        final File tempFile = new File( context.getExternalFilesDir( Environment.DIRECTORY_DOWNLOADS ), filename );
        if ( tempFile.exists() ) {
            openPDF( context, Uri.fromFile( tempFile ) );
            return;
        }

        // Show progress dialog while downloading
        final ProgressDialog progress = ProgressDialog.show( context,  "downloading" ,   "please wait for a while" , true );

        // Create the download request
        DownloadManager.Request r = new DownloadManager.Request( Uri.parse( pdfUrl ) );
        r.setDestinationInExternalFilesDir( context, Environment.DIRECTORY_DOWNLOADS, filename );
        final DownloadManager dm = (DownloadManager) context.getSystemService( Context.DOWNLOAD_SERVICE );
        BroadcastReceiver onComplete = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if ( !progress.isShowing() ) {
                    return;
                }
                context.unregisterReceiver( this );

                progress.dismiss();
                long downloadId = intent.getLongExtra( DownloadManager.EXTRA_DOWNLOAD_ID, -1 );
                Cursor c = dm.query( new DownloadManager.Query().setFilterById( downloadId ) );

                if ( c.moveToFirst() ) {
                    int status = c.getInt( c.getColumnIndex( DownloadManager.COLUMN_STATUS ) );
                    if ( status == DownloadManager.STATUS_SUCCESSFUL ) {
                        openPDF( context, Uri.fromFile( tempFile ) );
                    }
                }
                c.close();
            }
        };
        context.registerReceiver( onComplete, new IntentFilter( DownloadManager.ACTION_DOWNLOAD_COMPLETE ) );

        // Enqueue the request
        dm.enqueue( r );
    }

    public void showPDFUrl( final Context context, final String pdfUrl ) {
        if ( isPDFSupported( context ) ) {
            downloadAndOpenPDF(context, pdfUrl);
        } else {
            askToOpenPDFThroughGoogleDrive( context, pdfUrl );
        }
    }

    public void askToOpenPDFThroughGoogleDrive( final Context context, final String pdfUrl ) {
        new AlertDialog.Builder( context )
            .setTitle( "Online Reading" )
            .setMessage( "No App for pdf reading in this app, would you like to read it through Google Drive?" )
            .setNegativeButton( "NO", null )
            .setPositiveButton( "YES", new OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    openPDFThroughGoogleDrive(context, pdfUrl); 
                }
            })
            .show();
    }

    public void openPDFThroughGoogleDrive(final Context context, final String pdfUrl) {
        Intent i = new Intent( Intent.ACTION_VIEW );
        i.setDataAndType(Uri.parse("http://drive.google.com/viewer?url=" + pdfUrl ), "text/html" );
        context.startActivity( i );
    }

    public boolean isPDFSupported( Context context ) {
        Intent i = new Intent( Intent.ACTION_VIEW );
        final File tempFile = new File( context.getExternalFilesDir( Environment.DIRECTORY_DOWNLOADS ), "test.pdf" );
        i.setDataAndType( Uri.fromFile( tempFile ), "application/pdf" );
        return context.getPackageManager().queryIntentActivities( i, PackageManager.MATCH_DEFAULT_ONLY ).size() > 0;
    }


	public static final void openPDF(Context context, Uri localUri ) {
        Intent i = new Intent( Intent.ACTION_VIEW );
        i.setDataAndType( localUri,  "application/pdf" );
        context.startActivity( i );
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
