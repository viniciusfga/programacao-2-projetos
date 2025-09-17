public class Exemplo15 {

    public static void main(String[] args) {

        int[] nums = new int[]{5, 10, 30, 55, 66, 90, 100, 120, 200};

        int esquerda = 0;
        int direita = nums.length - 1;
        int count = 0;
        int target = 90;

        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;

            count++;
            System.out.println(meio);

            if (nums[meio] == target) {
                System.out.println("Encontrado");
                break;
            }
            if (nums[meio] > target) {
                direita = meio - 1;
            } else {
                esquerda = meio + 1;
            }

        }
    }
}
