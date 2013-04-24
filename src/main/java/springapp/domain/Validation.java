package springapp.domain;

public class Validation {
	
	public boolean isValid(String tillId, String userId)
	{
		boolean status = false;
		if (tillId.isEmpty() || userId.isEmpty())
			return status;
		else if (tillIdIsInvalid(tillId) || userIdIsInvalid(userId))
			return status;
		else
			status = true;
		
		return status;
	}

	public boolean isValidForUpdate(String tillId, String userId) {
		
		if ((tillId == null) && (userId == null)) return false;
		
		if (tillId != null)
		{
			if (tillIdIsInvalid(tillId)) return false; 
		}
		
		if (userId != null)
		{
			if (userIdIsInvalid(userId)) return false; 
		}		
		
		return true;
	}
	
	
	private boolean tillIdIsInvalid(String tillId)
	{
		return tillId.length()==0;
	}
	
	private boolean userIdIsInvalid(String userId)
	{
		return userId.length()==0;
	}
}
