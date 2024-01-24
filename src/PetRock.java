public class PetRock {
  private String name;
  private boolean happy = false;
  private Double num1;
  private Double num2;

  public PetRock(String name,Double num1,Double num2 ) {
    if(name.isEmpty()){
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.num1=num1;
    this.num2=num2;
  }

  public String getName() {
    return name;
  }

  public Double getNum1() {
    return num1;
  }

  public Double getNum2() {
    return num2;
  }

  public boolean isHapppy(){
    return happy;
  }

  public void playWithRock() {
    happy=true;
  }

  public void notPlayWithRock(){
    happy=false;
  }

  public String getHappyMessage(){
    if(!happy){
      throw new IllegalStateException();
    }
    return "I'm happy!";
  }

  public String getUnHappyMessage(){
    if(happy){
      throw new RuntimeException();
    }
    return "I'm unhappy";
  }

  public int getFavNumer(){
    return 42;
  }

  public void waitTillHappy(){
    while(!happy){

    }
  }

  @Override
  public String toString() {
    return "PetRock{" +
        "name='" + name + '\'' +
        ", happy=" + happy +
        ", num1=" + num1 +
        '}';
  }
}
