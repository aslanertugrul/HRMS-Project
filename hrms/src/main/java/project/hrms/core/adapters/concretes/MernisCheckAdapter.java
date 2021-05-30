package project.hrms.core.adapters.concretes;

import java.rmi.RemoteException;
import java.util.Locale;

import org.springframework.stereotype.Service;

import project.hrms.core.adapters.abstracts.MernisCheckService;
import project.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisCheckAdapter implements MernisCheckService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		
		KPSPublicSoapProxy client=new KPSPublicSoapProxy();
		boolean result=false;
		try {
			result=client.TCKimlikNoDogrula(
						Long.valueOf(candidate.getCandidateIdentityNumber()), 
						candidate.getRealUserName().toUpperCase(new Locale("tr","TR")), 
						candidate.getRealUserSurname().toUpperCase(new Locale("tr","TR")), 
						candidate.getCandidateBirthDate());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

}
