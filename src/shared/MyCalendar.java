package shared;

import java.util.GregorianCalendar;
import java.util.Observable;

public class MyCalendar extends Observable {
        
        private GregorianCalendar selectedDay;
        public enum CurrentView { DAY, WEEK, MONTH }
        private CurrentView currentView;
        private CurrentView previousView;
        
        public MyCalendar() {
                selectedDay = new GregorianCalendar();
                currentView = CurrentView.MONTH;
                previousView = currentView;
        }
        
        public GregorianCalendar getSelectedDay() {
                return selectedDay;
        }

        public void setSelectedDay(GregorianCalendar day) {
                selectedDay = day;
        setChanged();
        notifyObservers();
        clearChanged();
    }
        public CurrentView getCurrentView() {
                return currentView;
        }
        
        public CurrentView getPreviousView() {
                return previousView;
        }
        
        public void setCurrentView(CurrentView view) {
                previousView = currentView;
                currentView = view;
        }
        
}