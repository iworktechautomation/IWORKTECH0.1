package com.iworktech.test.Framework.Utils;

import net.bytebuddy.utility.RandomString;
import org.testng.annotations.Test;

public class RandomStringGenerators {

 public static String getRandomText(int size){
      return (RandomString.make(size));
 }

}
