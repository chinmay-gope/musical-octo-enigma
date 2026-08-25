void main() {

    System.out.println(countVowels("Education"));
    System.out.println(countVowels("ABCDE"));

    int[] arr = new int[10];
    isAutoMorphic(625);
    isAutoMorphic(76);
    isAutoMorphic(7);
}

void isAutoMorphic(int i) {

    int len = Integer.toString(i).length();
    int square = i * i;
    int lastDigits = square % (int) Math.pow(10, len);

    if (lastDigits == i) {
        System.out.println(i + " is AutoMorphic");
    } else {
        System.out.println(i + " is not AutoMorphic");
    }
}


int countVowels(String str) {
    int count = 0;
    for (char c : str.toLowerCase().toCharArray()) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            count++;
        }
    }

    return count;
}
