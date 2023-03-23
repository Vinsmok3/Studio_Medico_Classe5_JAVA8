package it.studiomedico.entities.recordEnum;

public enum RecordStatusENUM {
    ACTIVE("Active"),
    DELETED("Deleted");
    private String description;

    RecordStatusENUM(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
