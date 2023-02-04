import javafx.beans.property.SimpleStringProperty;

public class Column
{
  private final  SimpleStringProperty number;
  private final SimpleStringProperty partName;
  private final SimpleStringProperty criteriaName;
  private final SimpleStringProperty sourceName;
  private final SimpleStringProperty weightAmount;
  private final SimpleStringProperty factName1;
  private final SimpleStringProperty pointAmount1;
  private final SimpleStringProperty scoreAmount1;
  private final SimpleStringProperty factName2;
  private final SimpleStringProperty pointAmount2;
  private final SimpleStringProperty scoreAmount2;
  private final SimpleStringProperty factName3;
  private final SimpleStringProperty pointAmount3;
  private final SimpleStringProperty scoreAmount3;
  private final SimpleStringProperty factName4;
  private final SimpleStringProperty pointAmount4;
  private final SimpleStringProperty scoreAmount4;

  public Column(String num,String pName,String cName, String sName, String wAmount, String fName1, String pAmount1, String sAmount1, String fName2,String pAmount2, String sAmount2, String fName3, String pAmount3, String sAmount3, String fName4, String pAmount4, String sAmount4) {
    this.number = new SimpleStringProperty(num);
    this.partName = new SimpleStringProperty(pName);
    this.criteriaName = new SimpleStringProperty(cName);
    this.sourceName= new SimpleStringProperty(sName);
    this.weightAmount = new SimpleStringProperty(wAmount);
    this.factName1 = new SimpleStringProperty(fName1);
    this.pointAmount1 = new SimpleStringProperty(pAmount1);
    this.scoreAmount1 = new SimpleStringProperty(sAmount1);
    this.factName2 = new SimpleStringProperty(fName2);
    this.pointAmount2 = new SimpleStringProperty(pAmount2);
    this.scoreAmount2 = new SimpleStringProperty(sAmount2);
    this.factName3 = new SimpleStringProperty(fName3);
    this.pointAmount3 = new SimpleStringProperty(pAmount3);
    this.scoreAmount3 = new SimpleStringProperty(sAmount3);
    this.factName4 = new SimpleStringProperty(fName4);
    this.pointAmount4 = new SimpleStringProperty(pAmount4);
    this.scoreAmount4 = new SimpleStringProperty(sAmount4);
  }

  public String getNumber(){return number.get();}

  public void  setNumber(String num){
    number.set(num);
  }

  public String getPartName() {
    return partName.get();
  }

  public void setPartName(String pName) {
    partName.set(pName);
  }

  public String getCriteriaName() {
    return criteriaName.get();
  }

  public void setCriteriaName(String cName) {
    criteriaName.set(cName);
  }

  public String getSourceName() {
    return sourceName.get();
  }

  public void setSourceName(String sName) {
    sourceName.set(sName);
  }


  public String getWeightAmount() {
    return weightAmount.get();
  }

  public void setWeightAmount(String wAmount) {
    weightAmount.set(wAmount);
  }

  public String getFactName1() {
    return factName1.get();
  }

  public void setFactName1(String fName1) {
    factName1.set(fName1);
  }

  public String getPointAmount1() {
    return pointAmount1.get();
  }

  public void setPointAmount1(String pAmount1) {
    pointAmount1.set(pAmount1);
  }

  public String getScoreAmount1() {
    return scoreAmount1.get();
  }

  public void setScoreAmount1(String sAmount1) {
    scoreAmount1.set(sAmount1);
  }

  public String getFactName2() {
    return factName2.get();
  }

  public void setFactName2(String fName2) {
    factName2.set(fName2);
  }

  public String getPointAmount2() {
    return pointAmount2.get();
  }

  public void setPointAmount2(String pAmount2) {
    pointAmount2.set(pAmount2);
  }

  public String getScoreAmount2() {
    return scoreAmount2.get();
  }

  public void setScoreAmount2(String sAmount2) {
    scoreAmount2.set(sAmount2);
  }

  public String getFactName3() {
    return factName3.get();
  }

  public void setFactName3(String fName3) {
    factName3.set(fName3);
  }

  public String getPointAmount3() {
    return pointAmount3.get();
  }

  public void setPointAmount3(String pAmount3) {
    pointAmount3.set(pAmount3);
  }

  public String getScoreAmount3() {
    return scoreAmount3.get();
  }

  public void setScoreAmount3(String sAmount3) {
    scoreAmount3.set(sAmount3);
  }

  public String getFactName4() {
    return factName4.get();
  }

  public void setFactName4(String fName4) {
    factName4.set(fName4);
  }

  public String getPointAmount4() {
    return pointAmount4.get();
  }

  public void setPointAmount4(String pAmount4) {
    pointAmount4.set(pAmount4);
  }

  public String getScoreAmount4() {
    return scoreAmount4.get();
  }

  public void setScoreAmount4(String sAmount4) {
    scoreAmount4.set(sAmount4);
  }
}
