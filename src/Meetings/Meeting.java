package Meetings;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Meeting {
    private String name;
    private String responsiblePerson;
    private String description;
    private String category;
    private String type;
    private LocalDate startDate;
    private LocalDate endDate;


    public Meeting(String name, String responsiblePerson, String description,
                   String category, String type, String startDate, String endDate) {
        this.name = name;
        this.responsiblePerson = responsiblePerson;
        this.description = description;
        this.category = category;
        this.type = type;
        this.startDate = LocalDate.parse(startDate);
        this.endDate = LocalDate.parse(endDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "name='" + name + '\'' +
                ", responsiblePerson='" + responsiblePerson + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}' + '\n';
    }

    public static List<Meeting> filterByDescription(List<Meeting> meetingList, String description) {
        List<Meeting> meetingsbyDescription = new ArrayList<>();
        for (int i = 0; i < meetingList.size(); i++) {
            Meeting meeting = meetingList.get(i);
            if (meeting.getDescription().equals(description)) {
                meetingsbyDescription.add(meeting);
            }
        }
        return meetingsbyDescription;
    }

    public static List<Meeting> filterByResponsiblePerson(List<Meeting> meetingList, String responsiblePerson) {
        List<Meeting> meetingsByResponsiblePerson = new ArrayList<>();
        for (int i = 0; i < meetingList.size(); i++) {
            Meeting meeting = meetingList.get(i);
            if (meeting.getResponsiblePerson().equals(responsiblePerson)) {
                meetingsByResponsiblePerson.add(meeting);
            }
        }
        return meetingsByResponsiblePerson;
    }

    public static List<Meeting> filterByCategory(List<Meeting> meetingList, String category) {
        List<Meeting> meetingsByCategory = new ArrayList<>();
        for (int i = 0; i < meetingList.size(); i++) {
            Meeting meeting = meetingList.get(i);
            if (meeting.getCategory().equals(category)) {
                meetingsByCategory.add(meeting);
            }
        }
        return meetingsByCategory;
    }

    public static List<Meeting> filterByType(List<Meeting> meetingList, String type) {
        List<Meeting> meetingsByType = new ArrayList<>();
        for (int i = 0; i < meetingList.size(); i++) {
            Meeting meeting = meetingList.get(i);
            if (meeting.getType().equals(type)) {
                meetingsByType.add(meeting);
            }
        }
        return meetingsByType;
    }

    public static List<Meeting> filterByDate(List<Meeting> meetingList, LocalDate startDate) {
        List<Meeting> meetingsByDate = new ArrayList<>();
        for (int i = 0; i < meetingList.size(); i++) {
            Meeting meeting = meetingList.get(i);
            if (meeting.getStartDate().isEqual(startDate)) {
                meetingsByDate.add(meeting);
            } else if (meeting.getStartDate().isAfter(startDate)) {
                meetingsByDate.add(meeting);
            }
        }
        return meetingsByDate;
    }

    public static List<Meeting> filterByDates(List<Meeting> meetingList, LocalDate startDate, LocalDate startDate1) {
        List<Meeting> meetingsByDate = new ArrayList<>();
        for (int i = 0; i < meetingList.size(); i++) {
            Meeting meeting = meetingList.get(i);
            if (meeting.getStartDate().isEqual(startDate)) {
                meetingsByDate.add(meeting);
            } else if (meeting.getStartDate().isEqual(startDate1)) {
                meetingsByDate.add(meeting);
            } else if (meeting.getStartDate().isBefore(startDate1)) {
                meetingsByDate.add(meeting);
            }
        }
        return meetingsByDate;
    }


}
