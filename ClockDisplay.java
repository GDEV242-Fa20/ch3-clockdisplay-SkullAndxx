
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * Update: do 12 hour clock adjust user input instead of the display method
 * On second opinion, I like this method more because it 
 * uses an entirely new method.
 * 
 * @author Erick Rubio
 * @version 2020.09.28
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    private int tempHour; //display modified user time
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = get24HourInternalDisplay() + ":" + 
                        minutes.getDisplayValue();
    }
    
    /**
     * Set an input to hours needed for intake of 24 hours.
       */
      public int get24HourInternalDisplay(){
          
          if(hours.getValue()<13){
            if(hours.getValue() == 0){
                return tempHour = 12;
            }else{
                return tempHour = hours.getValue();
            }
          }else{
            if(hours.getValue() == 13){
                return tempHour = 12;
            }else{
                return tempHour = hours.getValue()%12;
            }
          }

        }
}

