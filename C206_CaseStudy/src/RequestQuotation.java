public class RequestQuotation extends C206_CaseStudy{
    private String PropertyType;
    private double AreaSize;
    private String RequestorName;
    private int ContactNumber;
    private String email;
    private double budget;
    private String TCdate;
    private String RenoType;
    private int NumRooms;
    private int Numtoilets;
    private boolean urgent ;

    public RequestQuotation(String propertyType, double areaSize, String requestorName, int contactNumber, String email,
            double budget, String tCdate, String renoType, int numRooms, int numtoilets, boolean urgent) {
        super();
        this.PropertyType = propertyType;
        this.AreaSize = areaSize;
        this.RequestorName = requestorName;
        this.ContactNumber = contactNumber;
        this.email = email;
        this.budget = budget;
        this.TCdate = tCdate;
        this.RenoType = renoType;
        this.NumRooms = numRooms;
        this.Numtoilets = numtoilets;
        this.urgent = urgent;
    }

    public String getPropertyType() {
        return PropertyType;
    }
    public void setPropertyType(String propertyType) {
        PropertyType = propertyType;
    }
    public double getAreaSize() {
        return AreaSize;
    }
    public void setAreaSize(double areaSize) {
        AreaSize = areaSize;
    }
    public String getRequestorName() {
        return RequestorName;
    }
    public void setRequestorName(String requestorName) {
        RequestorName = requestorName;
    }
    public int getContactNumber() {
        return ContactNumber;
    }
    public void setContactNumber(int contactNumber) {
        ContactNumber = contactNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public double getBudget() {
        return budget;
    }
    public void setBudget(double budget) {
        this.budget = budget;
    }
    public String getTCdate() {
        return TCdate;
    }
    public void setTCdate(String tCdate) {
        TCdate = tCdate;
    }
    public String getRenoType() {
        return RenoType;
    }
    public void setRenoType(String renoType) {
        RenoType = renoType;
    }
    public int getNumRooms() {
        return NumRooms;
    }
    public void setNumRooms(int numRooms) {
        NumRooms = numRooms;
    }
    public int getNumtoilets() {
        return Numtoilets;
    }
    public void setNumtoilets(int numtoilets) {
        Numtoilets = numtoilets;
    }
    public boolean getUrgent() {
        return urgent;
    }
    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

}