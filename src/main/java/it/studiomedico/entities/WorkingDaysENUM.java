package it.studiomedico.entities;

public enum WorkingDaysENUM {
    MONDAY("Monday",1),
    TUESDAY("Tuesday",2),
    WEDNESDAY("Wednesday",3),
    THURSDAY("Thursday",4),
    FRIDAY("Friday",5),
    SATURDAY("Saturday",6),
    SUNDAY("Sunday",7);

   private String days;
   private int id;

    WorkingDaysENUM(String days, int id) {
        this.days = days;
        this.id = id;
    }

    public void workingDays() {
        for (WorkingDaysENUM days : WorkingDaysENUM.values()) {
            System.out.println(days.name());
        }
    }
}






