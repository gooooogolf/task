/**
 * 
 */
package com.jsoft.dao;

import org.springframework.stereotype.Repository;

import com.jsoft.model.Status;

/**
 * @author Sirimongkol
 *
 */
@Repository("statusDAO")
public class StatusDAOImpl extends GenericDAOImpl<Status>  implements StatusDAO {

}
