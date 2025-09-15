
#include <stdio.h>

struct ListNode
{
    int val;
    struct ListNode *next;
};

struct ListNode *mergeTwoLists(struct ListNode *list1, struct ListNode *list2)
{

    if (list1 == NULL)
    {
        return list2;
    }
    else if (list2 == NULL)
    {
        return list1;
    }
    struct ListNode *head, *temp, *temp2;
    head = (struct ListNode *)malloc(sizeof(struct ListNode));
    if (list1->val < list2->val)
    {
        head->val = list1->val;
        list1 = list1->next;
    }
    else
    {
        head->val = list2->val;
        list2 = list2->next;
    }
    while (list1 != NULL && list2 != NULL)
    {
        if (list1->val < list2->val)
        {
            temp->next->val = list1->val;
            list1 = list1->next;
        }
        else
        {
            temp->next->val = list2->val;
            list2 = list2->next;
        }
    }
    if (list1 != NULL)
    {
        temp->next = list1;
    }
    else
    {
        temp->next = list2;
    }

    return head;
}