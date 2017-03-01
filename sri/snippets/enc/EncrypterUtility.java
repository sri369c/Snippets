package sri.snippets.enc;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.properties.PropertyValueEncryptionUtils;

public class EncrypterUtility
{
	//private static final String passwd = "X@!5FT+8sCxawHT9s_cjz=a=V?W=Dcrq_bEbnwf8PSe6HCz^hhvKm_Pbrb3Sw7t&";
	private static final String passwd = "S@cr&t^";
	private static final String randomText = "c:\\certs\\g2mm_ldap_devKeystore.jks";
	
	public static void main(String[] args)
	{
		System.out.println("randomText: " + randomText);
		
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword(passwd);
		encryptor.setAlgorithm("PBEWITHSHA256AND256BITAES-CBC-BC");
		encryptor.setProvider(new BouncyCastleProvider());
		encryptor.setProviderName("BC");
		
		String encodedText = PropertyValueEncryptionUtils.encrypt(randomText, encryptor);
		System.out.println("encodedText: " + encodedText);

		String decodedText = PropertyValueEncryptionUtils.decrypt(encodedText, encryptor);
		System.out.println("decodedText: " + decodedText);
	}
}
