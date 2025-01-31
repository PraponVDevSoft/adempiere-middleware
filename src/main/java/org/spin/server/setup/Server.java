/*************************************************************************************
 * Product: ADempiere Bot                                                            *
 * Copyright (C) 2012-2019 E.R.P. Consultores y Asociados, C.A.                      *
 * Contributor(s): Yamel Senih ysenih@erpya.com                                      *
 * This program is free software: you can redistribute it and/or modify              *
 * it under the terms of the GNU General Public License as published by              *
 * the Free Software Foundation, either version 3 of the License, or                 *
 * (at your option) any later version.                                               *
 * This program is distributed in the hope that it will be useful,                   *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of                    *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the                     *
 * GNU General Public License for more details.                                      *
 * You should have received a copy of the GNU General Public License                 *
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.            *
 ************************************************************************************/
package org.spin.server.setup;

import java.util.List;
import java.util.logging.Level;

/**
 * Determinate all ADempiere client setup values for Human Resource
 * @author Yamel Senih
 */
public class Server {
	/**	Host Name	*/
	private String host;
	/**	Port	*/
	private int port;
	/**	Certificate Chain	*/
	private String certificate_chain_file;
	/**	Private Key	*/
	private String private_key_file;
	/**	Trust Certificate	*/
	private String trust_certificate_collection_file;
	/**	Log Level	*/
	private String log_level;
	/**	ADempiere valid token	*/
	private String adempiere_token;
	/**	Embedded services	*/
	private List<String> services;
	/**
	 * Default constructor
	 * @param host
	 * @param port
	 * @param certificate_chain_file
	 * @param private_key_file
	 * @param trust_certificate_collection_file
	 * @param log_level
	 * @param adempiere_token
	 * @param services
	 */
	public Server(String host, int port, String certificate_chain_file, String private_key_file, String trust_certificate_collection_file, String log_level, String adempiere_token,  List<String> services) {
		this.host = host;
		this.port = port;
		this.certificate_chain_file = certificate_chain_file;
		this.private_key_file = private_key_file;
		this.trust_certificate_collection_file = trust_certificate_collection_file;
		this.log_level = log_level;
		this.adempiere_token = adempiere_token;
		this.services = services;
		if(this.log_level == null
				|| this.log_level.trim().length() == 0) {
			this.log_level = Level.WARNING.getName();
		}
	}
	
	/**
	 * Default constructor without parameters
	 */
	public Server() {
		this.log_level = Level.WARNING.getName();
	}

	/**
	 * @return the host
	 */
	public final String getHost() {
		return host;
	}

	/**
	 * @return the port
	 */
	public final int getPort() {
		return port;
	}

	/**
	 * @return the certificate_chain_file
	 */
	public final String getCertificate_chain_file() {
		return certificate_chain_file;
	}

	/**
	 * @return the private_key_file
	 */
	public final String getPrivate_key_file() {
		return private_key_file;
	}

	/**
	 * @return the trust_certificate_collection_file
	 */
	public final String getTrust_certificate_collection_file() {
		return trust_certificate_collection_file;
	}

	/**
	 * @return the isTlsEnabled
	 */
	public final boolean isTlsEnabled() {
		return getCertificate_chain_file() != null 
				&& getPrivate_key_file() != null;
	}
	
	/**
	 * Get Services
	 * @return
	 */
	public final List<String> getServices() {
		return services;
	}

	/**
	 * Log Level
	 * @return
	 */
	public final String getLog_level() {
		return log_level;
	}

	/**	
	 * Get ADempiere token
	 * @return
	 */
	public String getAdempiere_token() {
		return adempiere_token;
	}

	/**
	 * Validate is a service is enabled
	 * @param service
	 * @return
	 */
	public final boolean isValidService(String service) {
		if(service == null
				|| service.trim().length() == 0
				|| services == null) {
			return false;
		}
		return getServices()
			.stream()
			.filter(serviceToFind -> serviceToFind != null && serviceToFind.equals(service)).findFirst().isPresent();
	}

	@Override
	public String toString() {
		return "Server [host=" + host + ", port=" + port + ", certificate_chain_file=" + certificate_chain_file
				+ ", private_key_file=" + private_key_file + ", trust_certificate_collection_file="
				+ trust_certificate_collection_file + ", log_level=" + log_level + ", services=" + services + "]";
	}
}
