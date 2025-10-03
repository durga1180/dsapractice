package org.example.codility.office;

/**
 * There are N patients  number from 0 to N-1, who wants to visit the doctor. The doctor has S Possible appointment
 * slot number from 1 to S. Each of the patient has two preference. Patient K would like to visit the doctor during
 * either slot A of K or B of K. The doctor can treat only one patient during each slot. Is it possible to assign
 * every patient to one of their preferred slots so that there will be at most one patient assigned to each slot?
 * Write a java program that given two array A and B, both of N integer of Integer S written true if it is possible
 * to assign every patient to one of their preferred slot and false otherwise.
 * For example : A = {1,1,3}, B = {2,2,1} and S = 3, the function return true, we would assign patient in the
 * following way, 1,2,3 where the kth element of array represents the number of this slot to which patient K was assigned.
 * Another correct assignment would be an incorrect assignment as to patient would be incorrect assignment as to
 * patient would be assigned to slot 2.
 * This problem can be viewed as a Bipartite matching problem. The patients and the slots can be thought
 * of as two sets of nodes in a Bipartite Graph. A patient has an edge of two possible slots (as per their preferences)
 * The goal is to determine whether it is possible to assign each patient to one of their preferred slots such that no slot is
 * assigned to more than one patient.
 * Solution Approach:
 * 1. We need to determine if we can find a matching such that each patient can be assigned to one of their preferred
 * slots without conflicts
 * 2. This can be solved using Depth-First search (DFS) or Breadth First Search (BFS) approach for finding
 * augmenting paths, similar to the classic Bipartite matching algorithm.
 */
public class DoctorAppointment {
    public static void main(String[] args) {
        
    }
}
