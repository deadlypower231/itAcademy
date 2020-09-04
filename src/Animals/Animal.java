package Animals;

    public abstract class Animal implements ISaySomething{

        public String name;
        public int Age;

        public void saySmth(){
            System.out.println("some abstract animal voice");
        }

        public String getName() {
        return name;
    }

        public void setName(String name) {
        this.name = name;
    }

        public int getAge() {
        return Age;
    }

        public void setAge(int age) {
        Age = age;
    }

}
