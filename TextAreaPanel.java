import java.awt.*;
import java.awt.event.*;

class TextAreaPanel extends Frame
{
  private Panel textAreaPanel;
  TextArea msgInputArea;
  
  public TextAreaPanel()
  {
    textAreaPanel = new Panel();
    msgInputArea = new TextArea(" ",1,1);
  }
  
  private void addTextArea()
  {
    textAreaPanel.add(msgInputArea);
  }
  
  public Panel getPanel()
  {
    return textAreaPanel;
  }

    }