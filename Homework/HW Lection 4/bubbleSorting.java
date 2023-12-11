public class bubbleSorting {
    public static void main(String[] args) {
        int intArray[] = {31, 432, 3, 42, 51, 99, -1};
        boolean flag = true;
        int temp;
        for (int i = 0; i < intArray.length - 1; i++){
            for (int k = 0; k < intArray.length - i - 1; k++) {
                if (intArray[k] > intArray[k + 1]) {
                    temp = intArray[k];
                    intArray[k] = intArray[k + 1];
                    intArray[k + 1] = temp;
                    flag = true;
                }
            }
        }

        for (int num : intArray) {
            System.out.print(num + " ");
        }


    }
}

