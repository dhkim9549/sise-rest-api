package com.example.accessingdatamysql;

import java.net.InetAddress;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller	// This means that this class is a Controller
@RequestMapping(path="/sise") // This means URL's start with /resv (after Application path)
@CrossOrigin(origins = "*")
public class SiseController {

	private static final Logger log = LoggerFactory.getLogger(SiseController.class);

	@Autowired
	private TbAddrRepository tbAddrRepository;

	@Autowired
	private TbMapRepository tbMapRepository;

	@Autowired
	private TbKbSiseRepository tbKbSiseRepository;

	@Autowired
        private TbKabSiseRepository tbKabSiseRepository;

	@Autowired
        private TbOlprRepository tbOlprRepository;

	@Autowired
        private TbEhprRepository tbEhprRepository;

        @GetMapping(path="/addr")
        public @ResponseBody Iterable<TbAddr> getAddrByBdnm(@RequestParam String lwdgCd, @RequestParam String srchDvcd, @RequestParam String srchVal) {

		log.info("getAddrByBdnm() start...");
		log.info("lwdgCd = " + lwdgCd);
		log.info("srchDvcd = " + srchDvcd);
		log.info("srchVal = " + srchVal);

		srchVal = srchVal.replaceAll(" ", "");

		Iterable<TbAddr> rsltIt = null;

		if(srchDvcd.equals("1")) {
			rsltIt = tbAddrRepository.selectAddrNative(lwdgCd, srchVal);
		} else if(srchDvcd.equals("2")) {
                        rsltIt = tbAddrRepository.selectAddrNative2(lwdgCd, srchVal);
                }

		log.info("getAddrByBdnm() end...");

		return rsltIt;

        }

	@GetMapping(path="/addr1")
        public @ResponseBody Iterable<TbAddr> getAddr1(@RequestParam String lwdgCd, @RequestParam String bldgNm) {

                log.info("getAddr1() start...");
                log.info("lwdgCd = " + lwdgCd);
                log.info("bldgNm = " + bldgNm);

                bldgNm = bldgNm.replaceAll(" ", "");

                Iterable<TbAddr> rsltIt = null;

		rsltIt = tbAddrRepository.selectAddrNative(lwdgCd, bldgNm);

                log.info("getAddr1() end...");

                return rsltIt;

        }

	@GetMapping(path="/addr3")
        public @ResponseBody Iterable<TbAddr> getAddr3(@RequestParam String lwdgCd, @RequestParam String ltnoBno, @RequestParam String ltnoBuno) {

                log.info("getAddr3() start...");
                log.info("lwdgCd = " + lwdgCd);
                log.info("ltnoBno = " + ltnoBno);
		log.info("ltnoBuno = " + ltnoBuno);

		if(ltnoBuno.trim().equals("")) {
			ltnoBuno = "0";
		}

                Iterable<TbAddr> rsltIt = null;

                rsltIt = tbAddrRepository.selectAddrNative3(lwdgCd, ltnoBno, ltnoBuno);

                log.info("getAddr3() end...");

                return rsltIt;

        }

	@GetMapping(path="/map")
        public @ResponseBody Iterable<TbMap> getMap(@RequestParam String stnmUnonCd){
                // This returns a JSON or XML with the users
                return tbMapRepository.selectMapNative(stnmUnonCd);
        }

	@GetMapping(path="/kbSise")
        public @ResponseBody Iterable<TbKbSise> getKbSise(@RequestParam String kbHsDstgNo){
                // This returns a JSON or XML with the users
                return tbKbSiseRepository.selectKbSiseNative(kbHsDstgNo);
        }

	@GetMapping(path="/kabSise")
        public @ResponseBody Iterable<TbKabSise> getKabSise(@RequestParam String kabDnjiNo){
                // This returns a JSON or XML with the users
                return tbKabSiseRepository.selectKabSiseNative(kabDnjiNo);
        }

	@GetMapping(path="/olpr")
        public @ResponseBody Iterable<TbOlpr> getOlpr(@RequestParam String twprcDnjiNo){
                // This returns a JSON or XML with the users
                return tbOlprRepository.selectOlprNative(twprcDnjiNo);
        }

	@GetMapping(path="/ehpr")
        public @ResponseBody Iterable<TbEhpr> getEhpr(
			@RequestParam("lwdgCd") String lwdgCd, 
			@RequestParam("ltnoBno") String ltnoBno, 
			@RequestParam("ltnoBuno") String ltnoBuno) {

                return tbEhprRepository.selectEhprNative(
				lwdgCd,
				String.format("%4s", ltnoBno).replace(' ', '0'),
				String.format("%4s", ltnoBuno).replace(' ', '0')
		);
        }

	@GetMapping(path="/error")
        public @ResponseBody String error(){
                return "The page does not exist."; 
        }

	@GetMapping(path="/healthCheck")
        public @ResponseBody String getHealthCheck(@RequestParam String pStr){
		InetAddress local = null;
		try {
			local = InetAddress.getLocalHost();
			String ip = local.getHostAddress();
			log.info("local ip : " + ip);
		} catch (Exception e1) {
			log.error(e1.toString());
		}
                return "" + local;
        }
}
