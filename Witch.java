import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.security.SecureRandom;

public class Witch extends JPanel {

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.black);
		int cx = getWidth() / 2;
		int cy = getHeight() / 2;
		SecureRandom rand = new SecureRandom();
		int c1 = 1 + rand.nextInt(25);

		for (int i = 0; i < 4; i++) {

			g.drawRect(cx - 120 - i, cy - 90 + i, 154 , 160);

		}

		for (int i = 0; i < 20; i += 4) {
			int c2 = 1 + rand.nextInt(5);
			switch (c2) {
			case 1:
				g.setColor(Color.red);
				break;
			case 2:
				g.setColor(Color.blue);
				break;
			case 3:
				g.setColor(Color.GREEN);
				break;
			case 4:
				g.setColor(Color.cyan);
				break;
			case 5:
				g.setColor(Color.YELLOW);
				break;
			}
			g.drawOval(cx  - i, cy - 65 - i, 2 * (i + 3), 2 * i );
		}

		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hr = c.get(Calendar.HOUR);
		int min = c.get(Calendar.MINUTE);
		int sec = c.get(Calendar.SECOND);
		int x = c.get(Calendar.AM_PM);

		if (x == 0) {
			g.setColor(Color.GREEN);
			g.drawString(String.format("%s", "AM"), cx - 4, cy - 25);
		} else {
			g.setColor(Color.GREEN);
			g.drawString(String.format("%s", "PM"), cx - 4, cy - 25);
		}
		g.setFont(new Font("digital-7", Font.PLAIN, 50));
		g.setColor(Color.GREEN);
		g.drawString(String.format("%02d%s%02d", hr, ":", min), cx - 110, cy);

		g.setFont(new Font("digital-7", Font.PLAIN, 17));
		g.setColor(Color.GREEN);
		g.drawString(String.format("%02d", sec), cx - 4, cy);

		g.setFont(new Font("digital-7", Font.PLAIN, 20));
		String[] Month = { "  January  ", " February  ", "   March   ", "   April   ", "    May    ", "    JUNE   ", "    July     ", "  August  ",
				" September ", " October ", " November ", " December " };

		g.drawString(String.format("%02d%s%02d", day, Month[month], year), cx - 117, cy + 50);
		g.drawString(String.format("%s", "--|| Mehrab ||------"), cx - 115, cy + 20);
		g.drawString(String.format("%s", "------------------"), cx - 117, cy - 34);

		g.setFont(new Font("digital-7", Font.PLAIN, 20));

		String[] Days = { "SATURDAY", "SUNDAY", "MOMDAY", " TUEDAY", "WEDNESDAY", " THURDAY", "FRIDAY" };
		g.drawString(Days[c.get(Calendar.DAY_OF_WEEK)], cx - 100, cy - 55);

	}

	public static void main(String[] args) {

		JFrame f = new JFrame("digital clock");
		Witch p = new Witch();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(p);
		f.setSize(300, 300);
		f.setVisible(true);
		new Timer(1000, e -> p.repaint()).start();
	}
}
