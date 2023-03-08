package it.studiomedico.entities;

public enum WorkingDaysENUM {
    MONDAY(1,"Monday"),
    TUESDAY(2,"Tuesday"),
    WEDNESDAY(3,"Wednesday"),
    THURSDAY(4,"Thursday"),
    FRIDAY(5,"Friday"),
    SATURDAY(6,"Saturday"),
    SUNDAY(7, "Sunday");

    private final String daysENUM;
    private final long id;

    WorkingDaysENUM(long id, String daysENUM) {
        this.id = id;
        this.daysENUM = daysENUM;
    }

}
