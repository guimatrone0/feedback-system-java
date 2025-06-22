import com.feedbacksystem.model.Feedback;
import com.feedbacksystem.repository.InMemoryFeedbackRepository;
import com.feedbacksystem.service.FeedbackService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FeedbackService service = new FeedbackService(new InMemoryFeedbackRepository());
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEMA DE FEEDBACK ===");
        
        while (true) {
            System.out.println("\nDigite o feedback (ou 'sair' para encerrar):");
            String texto = scanner.nextLine();
            
            if (texto.equalsIgnoreCase("sair")) break;
            
            System.out.println("Nome do cliente:");
            String autor = scanner.nextLine();
            
            System.out.println("Categoria (Produto/Serviço/Atendimento):");
            String categoria = scanner.nextLine();
            
            System.out.println("Pontuação (1-5):");
            int pontuacao = Integer.parseInt(scanner.nextLine());
            
            Feedback fb = new Feedback(texto, autor, categoria, pontuacao);
            service.processarFeedback(fb);
            System.out.println("✅ Feedback registrado!");
        }
        
        // Exibir resultados
        System.out.println("\n=== RESULTADOS ===");
        service.listarFeedbacks().forEach(System.out::println);
        
        scanner.close();
    }
}