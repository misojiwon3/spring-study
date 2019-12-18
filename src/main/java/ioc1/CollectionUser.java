package ioc1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

// ������ = ��� + Overriding + ����ȯ
public class CollectionUser {
	public static void main(String[] args) {
		// 1. ������ �����̳ʸ� ����(����)�Ѵ�.
		ClassPathXmlApplicationContext container = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2. ������ �����̳ʷκ��� �׽�Ʈ�� ��ü�� �˻�(Lookup)�Ѵ�.
		CollectionBean bean = (CollectionBean) container.getBean("collection");
		String[] addressList = bean.getAddressList();
		
		System.out.println("�ּ� ���");
		for (String address : addressList) {
			System.out.println("---> " + address.toString());
		}
		
		// 3. ������ �����̳ʸ� �����Ѵ�.
		container.close();
	}
}
