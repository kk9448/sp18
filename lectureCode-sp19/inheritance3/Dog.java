public class Dog implements Comparable<Dog> {
    public String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    @Override
    public int compareTo(Dog uddaDog) {
        //assume nobody is messing up and giving us
        //something that isn't a dog.
        return size - uddaDog.size;
    }

    private static class NameComparator implements Comparator<Dog> {

        @Override
        public int compare(Dog x1, Dog x2) {
            return x1.name.compareTo(x2.name);
        }
    }

    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }



    public void bark() {
        System.out.println(name + " says: bark");
    }
}