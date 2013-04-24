package springapp.domain;

public class Validation {
	
	public boolean isValid(String tillId, String userId)
	{
		boolean status = false;
		if (tillId.isEmpty() || userId.isEmpty())
			return status;
		else if (tillId.length()==0 || userId.length() == 0)
			return status;
		else
			status = true;
		
		return status;
	}

	public boolean isValidForUpdate(String tillId, String userId) {		
		return (tillId != null) || (userId != null);
	}
}
