public class Length11
{
private int feet=0;
 private int inches=0;
        
  
     public Length11( int newFeet, int newInches)
   {
      
      this.feet = newFeet;
      this.inches = newInches;
   }
   public int getFeet()
   {
      return this.feet;
   }
   public void setFeet( int newFeet)
   {
      this.feet = newFeet;
   }
   public int getInches()
   {
   
      return this.inches;
   
   }
   public void setInches(int newInches)
   {
      this.inches = newInches;
   }
   public Length add(Length otherLength)
   {
      int newFeet = this.feet+ otherLength.feet;
      int newInches= this.inches+ otherLength.inches;
      while(newInches>12)
      {
      if(newInches>=12)
      newInches-=12;
      newFeet+=1;
      }
      return new Length(newFeet, newInches);
   }
   public Length subtract(Length otherLength)
   {
   if (otherLength.inches< this.inches)
   {
      this.feet--;
      this.inches+=12;
   }
   int newFeet = this.feet - otherLength.feet;
   int newInches =otherLength.inches - this.inches;
    return new Length(newFeet, newInches);

   }
   public boolean equals(Length otherLength)
   {
      if(this.feet == otherLength.feet && this.inches == otherLength.inches)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   public int compareTo(Length otherLength)
   {
    int n1 = (this.feet*12)+this.inches;
    int n2 = (otherLength.feet*12)+otherLength.inches;
    return n1 - n2;
   }
   public String toString()
   {
      return feet + "\'" + inches + "\"";
   }
   
   
   
   
}