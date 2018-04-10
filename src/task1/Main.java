package task1;

public class Main
{
    public static void main(String[] args)
    {
        // проверка работы MyArrayList

        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();

        System.out.println("myArrayList.size() = " + myArrayList.size());
        System.out.println("myArrayList.isEmpty() = " + myArrayList.isEmpty());

        myArrayList.add(0);
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(6);
        myArrayList.add(7);
        myArrayList.add(8);
        myArrayList.add(9);
        for (int i = 0; i < myArrayList.size(); i++)
        {
            System.out.println("i = " + i + "; value = " + myArrayList.get(i));
        }

        System.out.println("myArrayList.size() = " + myArrayList.size());

        System.out.println("myArrayList.isEmpty() = " + myArrayList.isEmpty());

        myArrayList.add(4,100);
        for (int i = 0; i < myArrayList.size(); i++)
        {
            System.out.println("i = " + i + "; value = " + myArrayList.get(i));
        }
        System.out.println("myArrayList.size() = " + myArrayList.size());
        System.out.println("myArrayList.contains(100) = " + myArrayList.contains(100));

        Object [] array = myArrayList.toArray();
        for (int i = 0; i < array.length; i++)
        {
            System.out.println("array[" + i + "] = " + array[i]);
        }

        myArrayList.remove(4);
        for (int i = 0; i < myArrayList.size(); i++)
        {
            System.out.println("i = " + i + "; value = " + myArrayList.get(i));
        }

        System.out.println("myArrayList.size() = " + myArrayList.size());

        System.out.println("myArrayList.indexOf(7) = " + myArrayList.indexOf(7));

        System.out.println("myArrayList.lastIndexOf(0) = " + myArrayList.lastIndexOf(0));

        myArrayList.set(0, 1000);
        for (int i = 0; i < myArrayList.size(); i++)
        {
            System.out.println("i = " + i + "; value = " + myArrayList.get(i));
        }

        myArrayList.clear();
        System.out.println("myArrayList.size() = " + myArrayList.size());
        System.out.println("myArrayList.isEmpty() = " + myArrayList.isEmpty());

        for (int i = 0; i < myArrayList.size(); i++)
        {
            System.out.println("i = " + i + "; value = " + myArrayList.get(i));
        }

        myArrayList.add(0);
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(6);
        myArrayList.add(7);
        myArrayList.add(8);
        myArrayList.add(9);

        for (int i = 0; i < myArrayList.size(); i++)
        {
            System.out.println("i = " + i + "; value = " + myArrayList.get(i));
        }
    }
}
