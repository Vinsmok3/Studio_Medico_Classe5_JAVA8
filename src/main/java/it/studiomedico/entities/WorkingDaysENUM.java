package it.studiomedico.entities;

public enum WorkingDaysENUM {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public void workingDays() {
        for (WorkingDaysENUM days : WorkingDaysENUM.values()) {
            System.out.println(days.name());

        }


    }
}






