import java.awt.*;
import javax.swing.*;
import com.crystaldecisions.ReportViewer.*;
import com.crystaldecisions.reports.sdk.*;
import com.crystaldecisions.sdk.occa.report.reportsource.*;

public class CrystalReportExcample {

	public static void createAndShowGUI()
    {
        try
        {
            //Make sure we have nice window decorations.
            JFrame.setDefaultLookAndFeelDecorated(true);
 
            //Create and set up the window.
            JFrame frame = new JFrame("HelloWorldSwing");
            frame.setTitle( "Testing Reports");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
           ReportViewerBean viewer = new ReportViewerBean();
            viewer.init( new String[0], null, null, null);
         
          ReportClientDocument rpt = new ReportClientDocument();
            rpt.open( "report path", 1 );

            IReportSource rptSource = rpt.getReportSource();
            viewer.setReportSource( rptSource );
         
            frame.getContentPane().add( viewer, BorderLayout.CENTER );
            frame.setSize( 700, 500 );
            frame.setVisible(true);

            viewer.start();
        }
        catch ( Exception exception )
        {
            System.out.println( exception.toString() );
        }
    }

    public static void main(String[] args) 
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                createAndShowGUI();
            }
        });
    }
}
