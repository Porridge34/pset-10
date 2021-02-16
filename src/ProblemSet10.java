public class ProblemSet10 {
    public static void main(String[] args) {
        ProblemSet10 test = new ProblemSet10();
        int[] arr1 = {1};
        int[] arr2 = {2, 4};
        int result = test.countClumps(arr1);
        System.out.println(result);
//        for (int temp : result) {
//            System.out.println(temp);
//        }
    }

    public String[]fizzBuzz(int start, int end) {
        if (start < end) {
            String[] result = new String[end - start];
            for (int i = start; i < end; i++) {
                if (i % 3 == 0) {
                    if (i % 5 == 0) {
                        result[i - start] = "FizzBuzz";
                    }
                    else {
                        result[i - start] = "Fizz";
                    }
                }
                else if (i % 5 == 0) {
                    result[i - start] = "Buzz";
                }
                else {
                    result[i - start] = String.valueOf(i);
                }
            }
            return result;
        }
        return null;
    }

    public int maxSpan(int[] numbers) {
        if (numbers != null) {
            if (numbers.length == 0) {
                return 0;
            }
            int maxSpan = 1;
            for (int i = 0; i < numbers.length; i++) {
                int currentSpan = 1;
                for (int j = i + 1; j < numbers.length; j++) {
                    if (numbers[i] == numbers[j]) {
                        currentSpan = j - i + 1;
                    }
                }
                if (currentSpan > maxSpan) {
                    maxSpan = currentSpan;
                }
            }
            return maxSpan;
        }
        return -1;
    }

    public int[] fix34(int[] numbers) {
        if (numbers != null) {
            int threes = 0;
            int fours = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == 3) {
                    if (i == numbers.length - 1 || numbers[i + 1] == 4) {
                        return null;
                    }
                    threes++;
                }
                else if (numbers[i] == 4) {
                    if (threes == 0) {
                        return null;
                    }
                    fours++;
                }
            }
            if (threes != fours) {
                return null;
            }
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] == 3) {
                    int temp = numbers[i + 1];

                    for (int j = i + 1; j < numbers.length; j++) {
                        if (numbers[j] == 4) {
                            numbers[j] = temp;
                        }
                    }
                    numbers[i + 1] = 4;
                }
            }

            return numbers;
        }
        return null;
    }

    public int[] fix45(int[] numbers) {
        if (numbers != null) {
            int fours = 0;
            int fives = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == 4) {
                    if (i == numbers.length - 1 || numbers[i + 1] == 4) {
                        return null;
                    }
                    fours++;
                }
                else if (numbers[i] == 5) {
                    fives++;
                }
            }
            if (fives != fours) {
                return null;
            }
            int lastfiveindex = 0;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] == 4) {
                    int temp = numbers[i + 1];

                    for (int j = lastfiveindex; j < numbers.length; j++) {
                        if (numbers[j] == 5) {
                            numbers[j] = temp;
                            lastfiveindex = j + 1;
                        }
                    }
                    numbers[i + 1] = 5;
                }
            }
            return numbers;
        }
        return null;
    }

    public boolean canBalance(int[] numbers) {
        if (numbers != null && numbers.length != 0) {
            if (numbers.length == 1) {
                return false;
            }
            for (int i = 0; i < numbers.length; i++) {
                int leftsum = 0;
                for (int j = 0; j < i; j++) {
                    leftsum += numbers[j];
                }
                int rightsum = 0;
                for (int j = i; j < numbers.length; j++) {
                    rightsum += numbers[j];
                }
                if (rightsum == leftsum) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean linearIn(int[] outer, int[] inner) {
        if (outer != null && inner != null && outer.length != 0 && inner.length != 0) {
            for (int i = 0; i < inner.length - 1; i++) {
                if (inner[i] > inner[i + 1]) {
                    return false;
                }
            }
            int innercount = 0;
            for (int i = 0; i < outer.length - 1; i++) {
                if (outer[i] > outer[i + 1]) {
                    return false;
                } else if (outer[i] == inner[innercount]){
                    innercount++;
                }
                if (innercount == inner.length) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[] squareUp(int n) {
        if (n >= 0) {
            int[] result = new int[n * n];
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j <= i; j++) {
                    result[i * n - j] = j;
                }
            }
            return result;
        }
        return null;
    }

    public int[] seriesUp(int n) {
        if (n >= 0) {
            int temp = 0;
            for(int i = 1; i <= n; i++){
                temp += i;
            }
            int[] result = new int[temp];
            int indexcount = 0;
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < i + 1; j++) {
                    result[indexcount] = j;
                    indexcount++;
                }
            }
            return result;
        }
        return null;
    }

    public int maxMirror(int[] numbers) {
        if (numbers != null) {
            if (numbers.length == 0) {
                return 0;
            }
            int maxMirror = 1;
            for (int i = 0; i < numbers.length; i++) {
                //this is the beginning index of the temparr in terms of the original array
                for (int j = numbers.length - 1; j > i; j--) {
                    //this is the ending index
                    int[] tempArr = new int[j - i + 1];
                    for (int k = 0; k < tempArr.length; k++) {
                        //copying numbers into temparr
                        tempArr[k] = numbers[i + k];
                    }
//                    for (int k : tempArr) {
//                        System.out.println(k);
//                    }
//                    System.out.println("BREAK");
                    int indexoftemparr = 0;
                    boolean continuation = false;
                    for (int k = numbers.length - 1; k >= 0; k--) {
                        //finding reverse match of temparr in numbers
                        if (indexoftemparr == tempArr.length) {
                            if (maxMirror < indexoftemparr) {
                                maxMirror = indexoftemparr;
                            }
                            k = 0;
                            continue;
                        }
                        if (numbers[k] == tempArr[indexoftemparr]) {

                            if (indexoftemparr > 0 && continuation == false) {
                                indexoftemparr = 0;
                                continue;
                            }
                            continuation = true;
                            indexoftemparr++;
                        }
                        else {
                            continuation = false;
                            indexoftemparr = 0;
                        }
                        if (indexoftemparr == tempArr.length) {
                            if (maxMirror < indexoftemparr) {
                                maxMirror = indexoftemparr;
                            }
                            k = 0;
                            continue;
                        }
                    }
                }
            }
            return maxMirror;
        }
        return -1;
    }

    public int countClumps(int[] numbers) {
        if (numbers != null) {
            if (numbers.length == 0) {
                return 0;
            }
            int clumpint = numbers[0];
            int clumpsCount = 0;
            boolean foundClump = false;
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] == clumpint) {
                    if (foundClump == false) {
                        clumpsCount ++;
                    }
                    foundClump = true;
                }
                else {
                    clumpint = numbers[i];
                    foundClump = false;
                }
            }
            return clumpsCount;
        }
        return -1;
    }
}
