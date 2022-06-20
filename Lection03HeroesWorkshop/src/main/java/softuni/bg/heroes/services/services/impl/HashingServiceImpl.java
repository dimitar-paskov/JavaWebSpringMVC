/**
 * @author dimitar
 *
 */
package softuni.bg.heroes.services.services.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import softuni.bg.heroes.services.services.HashingService;

@Service
public class HashingServiceImpl implements HashingService {

	@Override
	public String hash(String str) {
		
		return DigestUtils.sha256Hex(str); 
	}

}
