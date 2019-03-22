package aplicar;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.Pessoa;



public class Programa {

	public static void main(String[] args) throws Exception{
		
		Pessoa pessoa = new Pessoa();
		NodeList listaPessoas = leXML();
		
		geraLista(pessoa, listaPessoas);
			
	
	}

	private static void geraLista(Pessoa pessoa, NodeList listaPessoas) {
		for (int i = 0; i < listaPessoas.getLength(); i++) {
		
			Node noPessoa =  listaPessoas.item(i);

			if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
				
				Element elementoPessoa = (Element) noPessoa;
								
				pessoa.setId(Integer.parseInt(elementoPessoa.getAttribute("id")));
			
				
				System.out.println("\nPessoa = " + pessoa.getId());
				
				NodeList listaDeNosFilhos = elementoPessoa.getChildNodes();
				
				for (int j = 0; j < listaDeNosFilhos.getLength(); j++) {
					
					Node noFilho = listaDeNosFilhos.item(j);
					
					if(noFilho.getNodeType() == Node.ELEMENT_NODE) {
						
						Element elementoFilho = (Element) noFilho;
						switch (elementoFilho.getTagName()) {
						case "nome":
							pessoa.setNome(elementoFilho.getTextContent());
							break;
						case "idade":
							pessoa.setIdade(Integer.parseInt((elementoFilho.getTextContent())));
							break;
						case "peso":
							pessoa.setPeso(Double.parseDouble((elementoFilho.getTextContent())));
							break;

						default:
							break;
						}
						
						
					}
				}
				
			}
			System.out.println(pessoa);
		}
	}

	private static NodeList leXML() throws ParserConfigurationException, SAXException, IOException {
	
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder contrutor = fabrica.newDocumentBuilder();
		Document doc = contrutor.parse("src/pessoa.xml");
		NodeList listaPessoas =  doc.getElementsByTagName("pessoa");
		return listaPessoas;
	}

}

