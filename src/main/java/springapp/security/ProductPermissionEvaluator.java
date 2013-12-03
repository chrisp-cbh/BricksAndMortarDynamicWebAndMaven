package springapp.security;

//import net.petrikainulainen.spring.testmvc.user.dto.SecurityRole;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import springapp.domain.Product;

import java.io.Serializable;
import java.util.Collection;

public class ProductPermissionEvaluator implements PermissionEvaluator {

	@Override
	public boolean hasPermission(Authentication authentication,
			Object targetDomainObject, Object permission) {

		Object principal = authentication.getPrincipal();
		if (!(targetDomainObject instanceof Product))
			return false;

		if (!(principal instanceof UserDetails))
			return false;

		Product targetDomainProduct = (Product) targetDomainObject;

		UserDetails userDetails = (UserDetails) principal;

		return containsRole(userDetails.getAuthorities(),
				targetDomainProduct.getType());

	}

	private boolean containsRole(
			Collection<? extends GrantedAuthority> authorities, String type) {

		for (GrantedAuthority ga : authorities) {
			if (ga.getAuthority().equals(type))
				return true;
		}

		return false;
	}

	@Override
	public boolean hasPermission(Authentication authentication,
			Serializable targetId, String targetType, Object permission) {
		// Not required here.
		return false;
	}

	private String getRole(Collection<? extends GrantedAuthority> authorities) {
		return authorities.iterator().next().getAuthority();
	}
}
