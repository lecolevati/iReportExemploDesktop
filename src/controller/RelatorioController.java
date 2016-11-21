package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;
import persistence.GenericDao;

public class RelatorioController implements ActionListener{

	private JTextField tfEmpresa;

	public RelatorioController(JTextField tfEmpresa) {
		this.tfEmpresa = tfEmpresa;
	}

	private void geraRelatorio() {
		String empresa = tfEmpresa.getText();
		String jasper = "C:\\TEMP\\reportViagem1.jasper";
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("empresa", empresa);
		byte[] bytes = null;
		String path = "C:\\TEMP\\relatorio.pdf";
		FileOutputStream stream = null;
		try {
			stream = new FileOutputStream(path);
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());		}
		try {
			JasperReport relatorio = (JasperReport) JRLoader
					.loadObjectFromFile(jasper);
			bytes = JasperRunManager.runReportToPdf(relatorio, parametros,
					new GenericDao().getConnection());

			if (bytes != null) {
				File f = new File(path);
				if (f.exists()){
					f.delete();
				}
				stream.write(bytes);
			}

		} catch (JRException | IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			try {
				stream.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		geraRelatorio();
	}
}
