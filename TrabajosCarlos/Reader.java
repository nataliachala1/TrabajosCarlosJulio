public class Reader {
    
    public String id;
    public String name;
    public String email;

    public Reader(String id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }
    @Override
    public String toString(){
        return "Reader [ID=" + id + ", Name=" + name + ", Email" + email +"]";
    }
}
