package Meetings;

import javax.sound.midi.MetaEventListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static Meetings.Meeting.*;

public class Main {
    public static void main(String[] args) {

        String meetingData = "src/Meetings/file.txt";
        List<Meeting> meetingList = readFile(meetingData);
        System.out.println("Printed all meetings list");
        System.out.println(meetingList);

        List<Meeting> meetingList2 = filterByDescription(meetingList, "Jono Java meetas");
        System.out.println("Filtered meeting list by description");
        System.out.println(meetingList2);
        List<Meeting> meetingList3 = filterByResponsiblePerson(meetingList, "Saulius");
        System.out.println("Filtered meeting list by responsible person");
        System.out.println(meetingList3);
        List<Meeting> meetingList4 = filterByCategory(meetingList, "TeamBuilding");
        System.out.println("Filtered meeting list by category");
        System.out.println(meetingList4);
        List<Meeting> meetingList5 = filterByType(meetingList, "Live");
        System.out.println("Filtered meeting list by type");
        System.out.println(meetingList5);
        List<Meeting> meetingList6 = filterByDate(meetingList, LocalDate.parse("2022-01-01"));
        System.out.println("Filtered meeting list by date starting from 2022-01-01");
        System.out.println(meetingList6);
        List<Meeting> meetingList7 = filterByDates(meetingList, LocalDate.parse("2022-01-01"),
                LocalDate.parse("2022-02-01"));

        System.out.println("Filtered meeting list by dates between 2022-01-01 and 2022-02-01");
        System.out.println(meetingList7);
        System.out.println("List without deleted meetings by responsible person");
        List<Meeting> meetingList1 = deleteMeetingByResponsiblePerson(meetingList, "Kamile");
        System.out.println(meetingList1);

    }

    public static List<Meeting> readFile(String dataFilePath) {
        BufferedReader br;
        List<Meeting> meetings = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(dataFilePath));
            String line = br.readLine();
            while (line != null) {
                String[] dataValues = line.split(" ");
                String name = dataValues[0];
                String responsiblePerson = dataValues[1];
                String description = dataValues[2] + " " + dataValues[3] + " " + dataValues[4];
                String category = dataValues[5];
                String type = dataValues[6];
                String startDate = dataValues[7];
                String endDate = dataValues[8];
                line = br.readLine();

                Meeting meeting = new Meeting(name, responsiblePerson, description, category, type, startDate, endDate);
                meetings.add(meeting);

            }
            br.close();
        } catch (IOException e) {
            System.out.println("Unexpected error " + e);
        }
        return meetings;
    }


    public static List<Meeting> deleteMeetingByResponsiblePerson(List<Meeting> meetingList, String responsiblePerson) {
        Iterator<Meeting> meetingIterator = meetingList.iterator();
        while (meetingIterator.hasNext()) {
            if (meetingIterator.next().getResponsiblePerson().equals(responsiblePerson)) {
                meetingIterator.remove();
            }
        }
        return meetingList;
    }

}
