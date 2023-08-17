package tesco.shiftInterval.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class SiftService {

  public static void main(String[] args) {
    List<Shift> mergedShifts =
        SiftService.getMergedShifts1(List.of(new Shift(8, 10), new Shift(9, 12), new Shift(14, 16)));
    System.out.println(mergedShifts);
  }

  public static List<Shift> getMergedShifts(List<Shift> shiftList) {
    if (shiftList == null || shiftList.isEmpty()) {
      return Collections.emptyList();
    }

    List<Shift> result = new ArrayList<>();

    Integer startTime = shiftList.get(0).getStart();
    Integer endTime = shiftList.get(0).getEnd();

    for (int i = 1; i < shiftList.size(); i++) {
      Shift shift = shiftList.get(i);
      if (!Objects.equals(shift.start, endTime)) {
        result.add(new Shift(startTime, endTime));
        startTime = shift.start;
        endTime = shift.end;
      } else {
        endTime = shift.end;
      }
    }
    result.add(new Shift(startTime, endTime));
    return result;
  }

  public static List<Shift> getMergedShifts1(List<Shift> shiftList) {

    List<Shift> mergedShifts =
        new LinkedList<>(); // Stores the result // Initialise the shift boundary tracker for shifts

    int[] shiftBoundaryTracker = getShiftBoundaryTracker(shiftList);
    // Main logic
    int currentShiftStartTime = -1; // Keeps track of the start time of the current shift

    int numberOfShiftsActive =
        0; // Keeps track of the number of shifts active at a given point of time
    for (int i = 0; i < shiftBoundaryTracker.length; i++) {
      numberOfShiftsActive += shiftBoundaryTracker[i];
      if (numberOfShiftsActive == 0) {
        // numberOfShiftsActive is 0 if we haven't started with a shift yet
        // or we just ended a shift that had started in the past
        if (currentShiftStartTime != -1) {
          // If we just ended a shift that had started in the past, currentShiftStartTime // will be
          // >= 0
          // Add the current shift to the merged shift list
          mergedShifts.add(new Shift(currentShiftStartTime, i));
        } // Else, do nothing.
        currentShiftStartTime = -1; // Reset the start time
      } else if (numberOfShiftsActive >= 1 && currentShiftStartTime == -1) {
        currentShiftStartTime = i; // Start a new shift
      }
    }
    return mergedShifts;
  }

  private static int[] getShiftBoundaryTracker(List<Shift> shiftList) {
    int[] slotTracker = new int[24];
    for (Shift shift : shiftList) {
      slotTracker[shift.getStart()]++;
      slotTracker[shift.getEnd()]--;
    }
    return slotTracker;
  }
}
