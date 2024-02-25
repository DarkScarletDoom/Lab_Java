import java.util.Scanner;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class prog 
{
    public static boolean is_simple(int num)
    {
        boolean is_simple = true;
        for (int i = 2; i < num; i++)
        {
            if (num % i == 0)
            {
                is_simple = false;
            }
        }
        return is_simple;
    }

    public static boolean is_palindrom(int num)
    {
        int arr[];
        arr = new int[10];
        int i = 0;
        int copy_num = num;
        while (copy_num != 0)
        {
            arr[i] = copy_num % 10;
            // System.err.println(n % 10);
            copy_num = copy_num / 10;
            i++;
        }
        int newNum = 0;
        int k = 1;
        boolean num_is_begin = false;
        for(int j = 9; j >= 0; j--)
        {
            if (num_is_begin == false && arr[j] != 0)
            {
                num_is_begin = true;
            }
            System.err.printf("elem: %d\n", arr[j]);
            newNum += arr[j] * k;
            if (num_is_begin)
            {
                k *= 10;
            }
        }
        System.err.printf("new: %d\nold: %d\n", newNum, num);
        if (newNum == num)
        {
        return true;
        }
        else
        {
            return false;
        }
    }

    // числа дружные, если состоят из одних и тех же цифр
    public static boolean isFriends(int num1, int num2){
        // двусвязный список
        LinkedList<Integer> firstNums = new LinkedList<>();
        LinkedList<Integer> secondNums = new LinkedList<>();
        int copy_num = num1;

        // занесение элементов в списки
        while (copy_num != 0)
        {
            firstNums.add(copy_num % 10);
            copy_num = copy_num / 10;
        }
        copy_num = num2;
        while (copy_num != 0)
        {
            secondNums.add(copy_num % 10);
            copy_num = copy_num / 10;
        }

        //удаление повторяющихся элементов, с помощью хеш-таблицы
        Set<Integer> firstNumsNoDups = new LinkedHashSet<Integer>(firstNums);
        Set<Integer> secondNumsNoDups = new LinkedHashSet<Integer>(secondNums);
    
        return (firstNumsNoDups.equals(secondNumsNoDups)) ? true : false;
    }
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();

        exercises newExercise = new exercises();
        boolean response =  newExercise.isFriends(num1, num2);
        System.err.printf("%s\n", response);
    }
}