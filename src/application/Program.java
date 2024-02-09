package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		List<Lesson> list = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso? ");
		int response = scanner.nextInt();
		
		for (int i=1; i <= response; i++) {
			System.out.println();
			System.out.println("Dados da " + i + "a aula: ");
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char ch = scanner.next().charAt(0);
			System.out.print("Título: ");
			scanner.nextLine();
			String title = scanner.nextLine();
			if (ch == 'c') {
				System.out.print("URL do vídeo: ");
				String url = scanner.nextLine();
				System.out.print("Duração em segundos: ");
				int seconds = scanner.nextInt();
				list.add(new Video(title, url, seconds));
			} else {
				System.out.print("Descrição: ");
				String description = scanner.nextLine();
				System.out.print("Quantidade de questões: ");
				int questionCount = scanner.nextInt();
				list.add(new Task(title, description, questionCount));
			}
		}
		
		int sum = 0;
		for (Lesson l : list) {
			sum += l.duration();
		}
		
		System.out.println();
		System.out.println("DURAÇÃO TOTAL DO CURSO = " + sum + " segundos");
		
		scanner.close();
	}
}
