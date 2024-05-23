/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.deleteduplicatevaluenodesfromasortedlinkedlist;

/**
 *
 * @author Nhat Anh
 */
import java.io.*;
import java.util.*;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteDuplicateValueNodesFromASortedLinkedList {
    public static ListNode removeDuplicates(ListNode head) {
        if (head == null) return null;
        
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static ListNode createListFromInput(Scanner scanner) {
        int n = scanner.nextInt();
        if (n == 0) return null;

        ListNode head = new ListNode(scanner.nextInt());
        ListNode current = head;

        for (int i = 1; i < n; i++) {
            current.next = new ListNode(scanner.nextInt());
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            ListNode head = createListFromInput(scanner);
            head = removeDuplicates(head);
            printList(head);
        }

        scanner.close();
    }

}
