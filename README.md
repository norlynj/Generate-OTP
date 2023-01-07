# Generate-OTP
_Solution to CMSC 122 DSA Lab Exercise_

This program prompts the user n times with string input of the infix expression. It generates the OTP by dequeuing to the queue storage and evaluating postfix expression using stack implementation.

## Lab Overview
For this lab exercise, you will be creating an OTP generator using the queue data structure. Initially, you have to prompt the user n-times with string input of an infix expression. For each input, you have to process it to become a postfix expression using the stack data structure, and then store it in a queue. For simplicity, we will use parenthesis only as the grouping symbol. For the operators we will use as follows: multiplication ( * ), division ( / ),  addition ( + ), and subtraction ( - ).

You will then prompt the user to generate an OTP by dequeueing to your queue storage and evaluating that postfix expression using stack implementation. If the resulting evaluation has 4 digits, return that as the OTP. Else if it has less than 4 digits, append zeros in front to become 4 digits. Else if greater than 4 digits, return only the last 4 digits. Also, allow the user to have an option to add another input to your queue. If there is nothing left to dequeue, prompt the user to input infix expressions again. Please refer below for the mock-up interface in terminal.



