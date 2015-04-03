/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addhoc2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class Acm362 {
    public static void main(String[] args) throws IOException {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff=new BufferedReader(new FileReader(new File("362.txt")));
		int num = 1;
		long total_size = Long.parseLong(buff.readLine());
		long packet_size, received_size, last5_size;
		long elapsed;
		StringBuffer sbuf = new StringBuffer();
		
		while(total_size!=0) {
			last5_size = 0;
			elapsed = 0;
			received_size = 0;
			
			sbuf.append("Output for data set ");
			sbuf.append(num);
			sbuf.append(", ");
			sbuf.append(total_size);
			sbuf.append(" bytes:\n");

			while(received_size<total_size) {
				packet_size = Long.parseLong(buff.readLine());
				last5_size += packet_size;
				received_size += packet_size;
				elapsed++;

				if(elapsed%5==0) {
					if(last5_size>0) {
						long remaining = (total_size-received_size)*5;
						if(remaining%last5_size==0) {
							remaining /= last5_size;
						} else {
							remaining = remaining/last5_size+1;
						}
						sbuf.append("   Time remaining: ");
						sbuf.append(remaining);
						sbuf.append(" seconds\n");
						last5_size = 0;
					} else {
						sbuf.append("   Time remaining: stalled\n");
					}
				}
			}
			
			sbuf.append("Total time: ");
			sbuf.append(elapsed);
			sbuf.append(" seconds\n\n");
			total_size = Long.parseLong(buff.readLine());
			num++;
		}

		System.out.print(sbuf);
	}
}
