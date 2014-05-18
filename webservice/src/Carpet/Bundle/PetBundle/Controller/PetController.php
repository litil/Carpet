<?php

namespace Carpet\Bundle\PetBundle\Controller;

use FOS\RestBundle\Controller\Annotations\Route;
use FOS\RestBundle\Routing\ClassResourceInterface;

class PetController implements ClassResourceInterface
{    
    /**
     * @Route(requirements={"_format"="json"})
     */
    public function getAction($slug) 
    {}
    
    /**
     * @Route(requirements={"_format"="json"})
     */
    public function getEventsAction($slug) 
    {}
}
