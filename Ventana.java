import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Ventana extends JFrame{

	private Metodo M = new Sumar();
	
	private JButton btnSumar;
	private JButton btnRestar;
	private JButton btnMultiplicar;
	private JButton btnDividir;
	
	private JTextField txtOperador;
	private JTextField txtOperador_1;
	private JTextField txtResultado;
	
	public Ventana(){
		
		/********** CREACIÓN DE LA VENTANA **************/
		
		super("Calculadora");
		Container c = getContentPane();
		getContentPane().setLayout(null);
		
		this.setSize(400,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/********** CAMPOS DE TEXTO ************************/
		
		txtOperador = new JTextField();
		txtOperador.setText("Operador1");
		txtOperador.setBounds(23, 38, 86, 20);
		getContentPane().add(txtOperador);
		txtOperador.setColumns(10);
		
		txtOperador_1 = new JTextField();
		txtOperador_1.setText("Operador2");
		txtOperador_1.setBounds(142, 38, 86, 20);
		getContentPane().add(txtOperador_1);
		txtOperador_1.setColumns(10);
		
		txtResultado = new JTextField();
		txtResultado.setText("Resultado");
		txtResultado.setBounds(249, 116, 86, 20);
		getContentPane().add(txtResultado);
		txtResultado.setColumns(10);
		
		/********* BOTONES *****************/
		
		btnSumar = new JButton("Sumar");
		btnSumar.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				double opa = Double.parseDouble(txtOperador.getText());
				double opb = Double.parseDouble(txtOperador_1.getText());
				M = new Sumar();
				double aux = M.calcular(opa, opb);
				txtResultado.setText(Double.toString(aux));
			}
		});
		btnSumar.setBounds(81, 80, 89, 23);
		getContentPane().add(btnSumar);
		
		btnRestar = new JButton("Restar");
		btnRestar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				double opa = Double.parseDouble(txtOperador.getText());
				double opb = Double.parseDouble(txtOperador_1.getText());
				M = new Restar();
				double aux = M.calcular(opa, opb);
				txtResultado.setText(Double.toString(aux));
			}
		});
		btnRestar.setBounds(81, 115, 89, 23);
		getContentPane().add(btnRestar);
		
		btnMultiplicar = new JButton("Multiplicar");
		btnMultiplicar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				
				double opa = Double.parseDouble(txtOperador.getText());
				double opb = Double.parseDouble(txtOperador_1.getText());
				M = new Multiplicar();
				double aux = M.calcular(opa, opb);
				txtResultado.setText(Double.toString(aux));
			}
		});
		btnMultiplicar.setBounds(81, 152, 89, 23);
		getContentPane().add(btnMultiplicar);
		
		btnDividir = new JButton("Dividir");
		btnDividir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				
				double opa = Double.parseDouble(txtOperador.getText());
				double opb = Double.parseDouble(txtOperador_1.getText());
				M = new Dividir();
				double aux = M.calcular(opa, opb);
				txtResultado.setText(Double.toString(aux));
			}
		});
		btnDividir.setBounds(81, 186, 89, 23);
		getContentPane().add(btnDividir);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(btnSumar);
		bg.add(btnRestar);
		bg.add(btnMultiplicar);
		bg.add(btnDividir);
	}				
}