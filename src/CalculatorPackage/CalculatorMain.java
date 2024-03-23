package CalculatorPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorMain implements ActionListener
{
	
	//Hesap makinesinin çerçevesi için Cerceve adında bir JFrame tanımlama:
	JFrame Cerceve;
	
	//Hesap makinesinde sayıların yazılacağı ekranını tanımlama:
	JTextField YaziAlani;
	
	//Hesap yaparken kullanacağımız sayıların tuşlarını tanımlama:
	JButton[] SayiTuslari = new JButton[10];
	
	//Hesap yaparken kullanılacak matametiksel işlem tuşlarını tanımlama:
	JButton[] HesapTuslari = new JButton[9];
	
	//İşlem tuşlarını tanımlama:
	JButton ToplaTus , CikarTus , CarpTus , BolTus ;
	JButton EsitTus , SilTus , NoktaTus , TemizTus ;
	JButton NegTus ;
	
	//Hesap makinesinde bir fonta ihtiyaç duyduğumuzda kullanılacak yazı fontunu tanımlama:
	Font GenelFont = new Font("Arial",Font.BOLD,30);
	Font UfakFont = new Font("Arial",Font.BOLD,25);
	
	//Hesapta kullanılacak verileri tanımlama:
	double Sayi01 = 0,Sayi02 = 0,Sonuc = 0;
	char HesapIsareti;
	
	CalculatorMain()
	{
		//Hesap makinesinin çerçevesinin özelliklerini atama:
		//Çerçevenin ismi:
		Cerceve = new JFrame("Calculator");
		//X'e basılınca kapanma özelliği:
		Cerceve.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Çerçevenin boyutu:
		Cerceve.setSize(435,550);
		Cerceve.setLayout(null);
		
		//YaziAlani adındaki JTextField'ın özelliklerini(konum,font) tanımlama:
		YaziAlani = new JTextField();
		YaziAlani.setBounds(25, 25, 375, 50);
		YaziAlani.setFont(GenelFont);
		
		//YaziAlani'na Kullanıcının yazı yazmasını engellemek:
		YaziAlani.setEditable(false);
		
		//İşlem tuşlarının sembollerinin tanımlanması:
		ToplaTus = new JButton("+");
		CikarTus = new JButton("-");
		CarpTus = new JButton("×");
		BolTus = new JButton("÷");
		EsitTus = new JButton("=");
		SilTus = new JButton("Del");
		NoktaTus = new JButton(".");
		TemizTus = new JButton("Clr");
		NegTus = new JButton("(-)");
		
		//İşlem tuşlarının HesapTuslari adındaki arrayin içine tanımlanması:
		HesapTuslari[0] = ToplaTus;
		HesapTuslari[1] = CikarTus;
		HesapTuslari[2] = CarpTus;
		HesapTuslari[3] = BolTus;
		HesapTuslari[4] = EsitTus;
		HesapTuslari[5] = SilTus;
		HesapTuslari[6] = NoktaTus;
		HesapTuslari[7] = TemizTus;
		HesapTuslari[8] = NegTus;
		
		//İşlem tuşlarının eylemlerinin ActionListener tarafından dinlenmesini ,
		//bu tuşların fontunun tanımlanmasını ve tuşa tıklandığında tuşun dış kısmının çerçevelenmesini kapatmak 
		//için bir for döngüsünden yaralanmak:
		for(int i=0;i<9;i++) 
		{
			HesapTuslari[i].addActionListener(this);
			HesapTuslari[i].setFont(GenelFont);
			HesapTuslari[i].setFocusable(false);
		}
		
		//Görüntüsünü beğenmediğim için bu iki tuşun fontunun ayarlanması:
		HesapTuslari[7].setFont(UfakFont);
		HesapTuslari[5].setFont(UfakFont);
		
		//Yukarıdakinin aynısı fakat sayı tuşları birer birer artığı için tek tek tanımlayıp zaman harcamak yerine,
		//aynı for döngüsünü hem tuşu tanımlayıp hem de tuşun üzerine yazan sayıyı tanımlamak için kullandık:
		for(int i=0;i<10;i++) 
		{
			SayiTuslari[i] = new JButton(String.valueOf(i));
			SayiTuslari[i].addActionListener(this);
			SayiTuslari[i].setFont(GenelFont);
			SayiTuslari[i].setFocusable(false);
		}
		
		//Tuşların bulunacakları düzlemin belirtilmesi:
		NegTus.setBounds(125,100,75,50);
		TemizTus.setBounds(225,100,75,50);
		SilTus.setBounds(325,100,75,50);		
		SayiTuslari[7].setBounds(25,175,75,50);
		SayiTuslari[4].setBounds(25,250,75,50);
		SayiTuslari[1].setBounds(25,325,75,50);
		NoktaTus.setBounds(25,400,75,50);
		SayiTuslari[8].setBounds(125,175,75,50);
		SayiTuslari[5].setBounds(125,250,75,50);
		SayiTuslari[2].setBounds(125,325,75,50);
		SayiTuslari[0].setBounds(125,400,75,50);
		SayiTuslari[9].setBounds(225,175,75,50);
		SayiTuslari[6].setBounds(225,250,75,50);
		SayiTuslari[3].setBounds(225,325,75,50);
		EsitTus.setBounds(225,400,75,50);
		ToplaTus.setBounds(325,175,75,50);
		CikarTus.setBounds(325,250,75,50);
		CarpTus.setBounds(325,325,75,50);
		BolTus.setBounds(325,400,75,50);

		//Çerçeveye hesap makinesinin öğelerinin eklenmesi:
		Cerceve.add(NegTus);
		Cerceve.add(SilTus);
		Cerceve.add(TemizTus);
		Cerceve.add(NoktaTus);
		Cerceve.add(SayiTuslari[7]);
		Cerceve.add(SayiTuslari[4]);
		Cerceve.add(SayiTuslari[1]);
		Cerceve.add(SayiTuslari[8]);
		Cerceve.add(SayiTuslari[5]);
		Cerceve.add(SayiTuslari[2]);
		Cerceve.add(SayiTuslari[0]);
		Cerceve.add(SayiTuslari[9]);
		Cerceve.add(SayiTuslari[6]);
		Cerceve.add(SayiTuslari[3]);
		Cerceve.add(EsitTus);
		Cerceve.add(ToplaTus);
		Cerceve.add(CikarTus);
		Cerceve.add(CarpTus);
		Cerceve.add(BolTus);
		Cerceve.add(YaziAlani);
		Cerceve.setVisible(true);		
	}
	
	
	public static void main(String[] args) 
	{
		CalculatorMain hesapmakinesi = new CalculatorMain();		
	}

	
	public void actionPerformed(ActionEvent e) 
	{
		//Sayi tuşlarının yazi alanına sayi yazmalarını sağlamak
		for(int i=0;i<10;i++) 
		{
			if(e.getSource() == SayiTuslari[i]) 
			{
				YaziAlani.setText(YaziAlani.getText().concat(String.valueOf(i)));
			}
		}
		
		//Hesap tuşlarının yazi alanına sayi yazmalarını sağlamak
		if(e.getSource() == NoktaTus) 
		{
			if(YaziAlani.getText().contains(".")) 
			{//Noktayı direkt yazdırırsak kullanıcı sonsuz nokta yazabileceğinden SilTus'tan çaldığımız bu
				//işlemi bir if döngüsü içine koyup if döngüsünü de yazı alanındaki metinde
				//nokta olup olmadığını kontrol ettiriyoruz böylelikle sadece tek bir nokta olabiliyor metinde
				String SayiAmaString = YaziAlani.getText();
				YaziAlani.setText("");
				for(int i=0;i<SayiAmaString.length()-1;i++) 
				{
					YaziAlani.setText(YaziAlani.getText()+SayiAmaString.charAt(i));
				}				
			}
			//Tabi hala bir işlem sonrası gelen sayının yanına nokta yazdırarak iki noktaya sahip olabiliriz
			//ama bunu nasıl düzelticeğimi bilmiyorum
			YaziAlani.setText(YaziAlani.getText().concat("."));					
		}
		
		if(e.getSource() == ToplaTus) 
		{
			Sayi01 = Double.parseDouble(YaziAlani.getText());
			HesapIsareti = '+';
			YaziAlani.setText("");
		}
		
		if(e.getSource() == CikarTus) 
		{
			Sayi01 = Double.parseDouble(YaziAlani.getText());
			HesapIsareti = '-';
			YaziAlani.setText("");
		}
		
		if(e.getSource() == CarpTus) 
		{
			Sayi01 = Double.parseDouble(YaziAlani.getText());
			HesapIsareti = '×';
			YaziAlani.setText("");
		}
		
		if(e.getSource() == BolTus) 
		{
			Sayi01 = Double.parseDouble(YaziAlani.getText());
			HesapIsareti = '÷';
			YaziAlani.setText("");
		}
		
		//Eşittir tuşunun ekrana yazılmasını ve hesabın yapılmasını sağlamak:
		if(e.getSource() == EsitTus) 
		{
			Sayi02=Double.parseDouble(YaziAlani.getText());
			switch(HesapIsareti) 
			{
			case'+':
				Sonuc=Sayi01+Sayi02;
				break;
			case'-':
				Sonuc=Sayi01-Sayi02;
				break;
			case'×':
				Sonuc=Sayi01*Sayi02;
				break;
			case'÷':
				Sonuc=Sayi01/Sayi02;
				break;
			}
			//Sonucun YaziAlani'na yazdırılması
			YaziAlani.setText(String.valueOf(Sonuc));
			
			//İşleme devam edebilmek için sonucu ilk sayı olarak var saydık
			Sayi01 = Sonuc;			
		}
		
		//Clr tuşuna işlev eklenmesi:
		if(e.getSource() == TemizTus) 
		{
			YaziAlani.setText("");
		}
		
		//Del tuşuna işlev eklenmesi:
		if(e.getSource() == SilTus) 
		{
			String SayiAmaString = YaziAlani.getText();
			YaziAlani.setText("");
			for(int i=0;i<SayiAmaString.length()-1;i++) 
			{
				YaziAlani.setText(YaziAlani.getText()+SayiAmaString.charAt(i));
			}
		}
		
		//Negatif sayi elde etmek için YaziAlani içerisindeki metini alıp -1 ile çarpıyoruz:
		if(e.getSource() == NegTus) 
		{
			double Gecici = Double.parseDouble(YaziAlani.getText());
			Gecici*=(-1);
			YaziAlani.setText(String.valueOf(Gecici));
		}
		
		
		
	}

}
