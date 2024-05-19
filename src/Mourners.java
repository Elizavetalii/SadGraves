public abstract class Mourners {
    private String Surname;
    private String Lastname;
    private String Middlename;
    private int LastDay;
    private int LastMonth;
    private int LastYear;

    public Mourners(String surname,String lastname,String middlename,
                    int lastDay, int lastMonth, int lastYear) {
        this.Surname = surname;
        this.Lastname = lastname;
        this.Middlename = middlename;
        this.LastDay = lastDay;
        this.LastMonth = lastMonth;
        this.LastYear = lastYear;
    }

    public String getSurname(){
        return Surname;
    }
    public String getLastname(){
        return Lastname;
    }
    public String getMiddlename(){
        return Middlename;
    }
    public int getLastMonth(){
        return LastMonth;
    }
    public int getLastDay(){
        return LastDay;
    }
    public int getLastYear(){
        return LastYear;
    }
    public abstract String getFullName();
}

 class Person extends Mourners {
    public Person(String Surname, String Lastname, String Middlename,
                  int lastDay, int lastMonth, int lastYear) {
        super(Surname, Lastname, Middlename, lastDay, lastMonth, lastYear);
    }

    @Override
    public String getFullName() {
        return "ФИО: " + getSurname() + " " + getLastname() + " " + getMiddlename();
    }
}
