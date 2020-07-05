import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class homePanel extends JPanel
{
	// homePanel contents
	JLabel AZBSLabel, officeAddressHeadingLabel, officeAttentdentLabel, officeAddressLabel;
	
	homePanel(int jframeWidth, int jframeHeight)
	{
//		this.setBackground(Color.DARK_GRAY);
		this.setLayout(null);
		this.setVisible(true);
		this.setBounds(0, 0, jframeWidth, jframeHeight);

		AZBSLabel = new JLabel("AUDICHYA ZALAWADI BRAHM SAMAJ - RAJKOT");
		AZBSLabel.setForeground(Color.WHITE);
		AZBSLabel.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 30));
		AZBSLabel.setBounds((jframeWidth/2)-345, (jframeHeight/2)-15, 690, 30);
		AZBSLabel.setFocusable(false);
//		Map attributes = AZBSLabel.getFont().getAttributes();
//		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
//		AZBSLabel.setFont(AZBSLabel.getFont().deriveFont(attributes));

		officeAddressHeadingLabel = new JLabel("OFFICE ADDRESS : ");
		officeAddressHeadingLabel.setForeground(Color.LIGHT_GRAY);
		officeAddressHeadingLabel.setFont(new Font("Cambria", Font.BOLD, 17));
		officeAddressHeadingLabel.setBounds(jframeWidth-600, jframeHeight-150, 200, 30);
		officeAddressHeadingLabel.setFocusable(false);
		
		officeAttentdentLabel = new JLabel("RAJESHBHAI P. JOSHI");
		officeAttentdentLabel.setForeground(Color.LIGHT_GRAY);
		officeAttentdentLabel.setFont(new Font("Cambria", Font.BOLD, 17));
		officeAttentdentLabel.setBounds(jframeWidth-600, jframeHeight-120, 250, 30);
		officeAttentdentLabel.setFocusable(false);
		
		officeAddressLabel = new JLabel("Amrut Menor, Block No. A-101, Jagnath Plot 14/3, Near Gymkhana, Rajkot");
		officeAddressLabel.setForeground(Color.LIGHT_GRAY);
		officeAddressLabel.setFont(new Font("Cambria", Font.PLAIN, 17));
		officeAddressLabel.setBounds(jframeWidth-600, jframeHeight-90, 550, 30);
		officeAddressLabel.setFocusable(false);
		
		this.add(AZBSLabel);
		this.add(officeAddressHeadingLabel);
		this.add(officeAttentdentLabel);
		this.add(officeAddressLabel);
		this.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e) {
		//		this.setVisible(false);
		//		adminLoginPanel.setVisible(true);
		//		memberLoginPanel.setVisible(true);
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
		});
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("cleanwood_1.jpg");
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
