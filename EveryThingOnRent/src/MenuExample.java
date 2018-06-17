import java.applet.*;
import java.awt.*;
class MenuExample1 extends Frame
{
	String msg="";
	MenuExample1(String title)
	{
		super(title);
	MenuBar mb=new MenuBar();
	setMenuBar(mb);
	Menu file=new Menu("File");
	Menu edit=new Menu("Edit");
	Menu format=new Menu("Format");
	MenuItem open=new MenuItem("Open FIle..");
	MenuItem  n=new MenuItem("New");
	MenuItem  n2=new MenuItem("Save");
	MenuItem n3=new MenuItem("Save As..");
	MenuItem n4=new MenuItem("Close");
	MenuItem n5=new MenuItem("Exit");
	MenuItem close=new MenuItem("Close");
	MenuItem SelectAll=new MenuItem("selectAll");
	MenuItem W=new MenuItem("Word Wrap");
	MenuItem  f=new MenuItem("Font");
	file.add(n);
	file.add(n2);
	file.add(n3);
	file.add(open);
	file.add(n4);
	file.add(n5);
	mb.add(file);
	mb.add(edit);
	mb.add(format);
	edit.add(close);
	edit.add(SelectAll);
	format.add(W);
	format.add(f);
	}
}
public class MenuExample extends Applet
{
	Frame f;
public	void init()
	{
		f=new MenuExample1("My Apps");
		setSize(new Dimension(500,500));
		f.setSize(new Dimension(500,500));
		f.setVisible(true);
	}
public void start()
{
	f.setVisible(true);
}
public void stop()
{
	f.setVisible(false);
}
}