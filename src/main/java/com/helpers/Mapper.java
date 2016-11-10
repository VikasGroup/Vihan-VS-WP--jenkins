package com.helpers;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import net.sourceforge.htmlunit.corejs.javascript.ast.WhileLoop;

public class Mapper {
	
	public static Map<Integer ,Map> map() throws Exception{
		
		Map <Integer,Map> data = new HashMap<Integer,Map>();
		
		ResultSet resultSet = DB.result("SELECT * FROM time");
		
			
		int x =1;
		while(resultSet.next()){
			Map <Integer,String> row = new HashMap<Integer,String>();
			System.out.println(row.get(1)+"oooooooooooooooo");
			System.out.println(resultSet.getString(6)+"ppppppppppppp"+row.size());
			row.put(0,resultSet.getString(6) );
			if(resultSet.getString(7).equals("1")){
				
				if(resultSet.getString(6).equals("Vihan")){
					System.out.println("vihan1999999999999");
					//row.put(0,resultSet.getString(6) );
					row.put(2,resultSet.getString(2));
					row.put(6,resultSet.getString(3));
					row.put(10,resultSet.getString(4));
					row.put(14,resultSet.getString(5));
				}
				else if(resultSet.getString(6).equals("World Plan")){
					System.out.println("wp188888888888888888888");
					//row.put(0,resultSet.getString(6) );
					row.put(2,resultSet.getString(2));
					row.put(6,resultSet.getString(3));
					row.put(10,resultSet.getString(4));
					row.put(14,resultSet.getString(5));
				}
			}
			else if(resultSet.getString(7).equals("2")){
				//row.put(1,resultSet.getString(6) );
				if(resultSet.getString(6).equals("Vihan")){
					System.out.println("vihan2");
					row.put(3,resultSet.getString(2));
					row.put(7,resultSet.getString(3));
					row.put(11,resultSet.getString(4));
					row.put(15,resultSet.getString(5));
				}
				if(resultSet.getString(6).equals("World Plan")){
					System.out.println("wp2");
					row.put(3,resultSet.getString(2));
					row.put(7,resultSet.getString(3));
					row.put(11,resultSet.getString(4));
					row.put(15,resultSet.getString(5));
				}
			}
			else if(resultSet.getString(7).equals("3")){
				//row.put(1,resultSet.getString(6) );
				if(resultSet.getString(6).equals("Vihan")){
					System.out.println("vihan3");
					row.put(4,resultSet.getString(2));
					row.put(8,resultSet.getString(3));
					row.put(12,resultSet.getString(4));
					row.put(16,resultSet.getString(5));
				}
				if(resultSet.getString(6).equals("World Plan")){
					System.out.println("wp3");
					row.put(4,resultSet.getString(2));
					row.put(8,resultSet.getString(3));
					row.put(12,resultSet.getString(4));
					row.put(16,resultSet.getString(5));
				}
         
			}
			
			  System.out.println(row);
			data.put(x,row );
			
			x++;
			System.out.println(data);
		}
		
	
		System.out.println(data);
		
		return data;
		
	}

}
